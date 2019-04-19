package com.notes;

/**
 * 账户交易
 * @author tianwei
 * @since 2019-04-19 15:34
 */
public interface TransferAccountsService {

    /**
     * 转账
     * @param transferDTO 转账DTO
     *                    orderNo订单号
     *                    amount转账金额
     *                    outUser出账帐号
     *                    inUser入账帐号
     *                    token签名
     *                    time时间戳
     *                    random随机数
     * 安全：使用token和时间戳随机数来防篡改请求
     * 幂等：幂等表来控制重复请求情况
     * 账户安全：1.更新账户操作使用version乐观锁来更新，不会超扣。
     *         2.使用TCC来预占/确认/回滚账户金额，先扣款，后转账
     *         3.事务出现异常时最大努力补偿，补偿3次后人工介入
     *
     * 异常分支：a.安全性校验不通过；
     *         b.参数校验不通过；
     *         c.重试不通过；
     *         d.余额不足；
     *         f:扣款、付款失败。
     * 用户投诉：可以查询入账流水，出账流水，整个请求操作流水，每个流水分别有状态
     *
     * @param transferDTO 转账DTO
     * @return success是否成功,message提示信息
     */
    Result transferAccounts(TransferDTO transferDTO);
}
