package com.notes;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tianwei
 * @since 2019-04-19 15:35
 */
public class AccountOperationBizImpl implements AccountOperationBiz {
    /**
     * 事务管理
     */
    @Autowired
    private AccountOperationManager accountOperationManager;

    /**
     * 转账
     * 
     * @param transferDTO
     * @return
     */
    public void transferAccounts(TransferDTO transferDTO) {
        // 幂等查询校验
        // 根据订单号查询操作日志是否已经处理（每次操作的订单号要求不一样）
        AmountLog log = accountOperationBiz.queryAmountLogByOrderId(transferDTO.getOrderId());
        if (log != null && log.getstatus == "已完成") {
            return new Result(false, "请求已处理");
        }

        if (log != null && log.getstatus == "请求处理补偿中") {
            return new Result(false, "处理补偿中,稍后重试");
        }

        // 查询出账账户余额
        AccountDO outUserAmount = transferMoneyMapper.getBalance(transferDTO.getoutUser());
        if (accountInfo.getAmount() > transferDTO.getAmount()) {
            throw new Exception("余额不足！");
        }

        // 查询入账账户信息
        AccountDO inUserAmount = transferMoneyMapper.getBalance(transferDTO.getinUser());
        // 判断账户是否存在风险
        if (accountInfo.getStatus() != "正常") {
            throw new Exception("余额不足！");
        }

        // 记录本次操作日志，日志状态为处理中(如果处理失败启动定时任务轮询补偿)
        accountOperationBiz.addTransferAmountLog(transferDTO);

        boolean tryResult = false;
        try {
            // 预占冻结扣款账户金额（增加预占记录用于回滚，确认）
            tryResult = this.tryOutDecrease(transferDTO);
            // 尝试增加入账账户冻结金额（冻结金额无法使用）
            tryResult = this.tryinDecrease(transferDTO);

            // 如果确认账户金额时异常，人工介入
            // 确认出账金额进行扣减
            this.confirmOutDecrease(transferDTO);
            // 确认入账账户金额
            this.confirminDecrease(transferDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (!tryResult) {
                try {
                    // 回滚入账账户金额，更改日志状态为已回滚
                    this.rollBackInDecrease(transferDTO);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    // 异常重试，或者发mq重试
                }
            }
        }
    }

    private boolean tryinDecrease(TransferDTO transferDTO) {
        try {
            // 乐观锁更新冻结余额

            // 增加预占流水

            // 新增幂等表数据（并发情况下会触发唯一索引）
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BizException("预占失败");
        }
        return true;
    }

    public boolean tryOutDecrease(TransferDTO transferDTO) {
        try {
            // 乐观锁更新冻结余额

            // 增加预占流水

            // 新增幂等表数据（并发情况下会触发唯一索引）
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BizException("预占失败");
        }
        //
        return true;
    }


    private void confirminDecrease(TransferDTO transferDTO) {
        try {
            // 乐观锁更新冻结余额

            // 更新确认流水状态

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BizException("确认失败");
        }
    }

    private void confirmOutDecrease(TransferDTO transferDTO) {
        try {
            // 乐观锁更新冻结余额

            // 更新确认流水状态

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BizException("确认失败");
        }
    }

    private void rollBackInDecrease(TransferDTO transferDTO) {
        try {
            // 回滚入账金额
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // 告警，人工处理，定时任务补偿/或者发mq
        }
    }

}
