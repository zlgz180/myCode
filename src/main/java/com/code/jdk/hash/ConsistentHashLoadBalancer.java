package com.my.code.jdk.hash;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.my.code.jdk.hash.strategy.HashStrategy;
import com.my.code.jdk.hash.strategy.JdkHashCodeStrategy;

/**
 * 一致性hash
 *
 * @author tianwei
 * @since 2019/3/12 12:46
 */
public class ConsistentHashLoadBalancer implements LoadBalancer {
    private final static int VIRTUAL_NODE_SIZE = 10;
    private final static String VIRTUAL_NODE_SUFFIX = "&&";
    private HashStrategy hashStrategy = new JdkHashCodeStrategy();

    @Override
    public Server select(List<Server> servers, Invocation invocation) {
        // 计算hash值
        int invocationHashCode = hashStrategy.getHashCode(invocation.getHashKey());
        // 把服务器url+端口映射到10虚拟节点的环上
        TreeMap<Integer, Server> ring = this.buildConsistentHashRing(servers);
        //
        return this.locate(ring, invocationHashCode);
    }

    private Server locate(TreeMap<Integer, Server> ring, int invocationHashCode) {
        // 向右找到第一个 key
        Map.Entry<Integer, Server> locateEntry = ring.ceilingEntry(invocationHashCode);
        if (locateEntry == null) {
            // 想象成一个环，超过尾部则取第一个 key
            locateEntry = ring.firstEntry();
        }
        return locateEntry.getValue();
    }

    /**
     * 使用 TreeMap 作为一致性哈希环的数据结构<br>
     * ring.ceilingEntry 可以获取环上最近的一个节点。<br>
     * 在 buildConsistentHashRing 之中包含了构建一致性哈希环的过程，默认加入了 10 个虚拟节点。
     * 
     * @param servers
     * @return
     */
    private TreeMap<Integer, Server> buildConsistentHashRing(List<Server> servers) {
        TreeMap<Integer, Server> virtualNodeRing = new TreeMap<>();
        for (Server server : servers) {
            for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
                // 新增虚拟节点的方式如果有影响，也可以抽象出一个由物理节点扩展虚拟节点的类
                virtualNodeRing.put(hashStrategy.getHashCode(server.getUrl() + VIRTUAL_NODE_SUFFIX + i), server);
            }
        }
        return virtualNodeRing;
    }
}
