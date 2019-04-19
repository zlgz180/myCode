package com.notes;

public interface TransferMoneyMapper {

    /**
     * 根据AccountId获取账户信息
     * 
     * @param payAccountId 账户ID
     * @return 账户实体
     */
    AccountDO getBalance(String payAccountId);

    /**
     * 保存交易信息 其中transactionId设为唯一约束
     * 
     * @param transferDTO 实体
     */
    void saveRecord(TransferDTO transferDTO);

    /**
     * sql: update table set amount = amount - #{amount},version_id = #{versionId} +
     * 1 where accountId = #{accountId} and version_id = #{versionId}
     * 
     * @param payAccountId 账户ID
     * @param amount 金额（分）
     * @param versionId 版本ID
     */
    void decrease(String payAccountId, Long amount, Long versionId);


    /**
     * 根据transactionId更新状态 sql: update table set status = #{newStatus} where
     * transactionId = #{transactionId} and status = #{oldStatus}
     * 
     * @param transactionId
     * @param oldStatus 老状态值：1：已收款，2已付款
     * @param newStatus 新状态值：1：已收款，2已付款
     */
    Integer updateStatus(String transactionId, int oldStatus, int newStatus);

    /**
     * sql: update table set amount = amount + #{amount} where accountId
     * =#{accountId}
     * 
     * @param recAccountId 账户ID
     * @param amount 金额（分）
     */
    void increase(String recAccountId, Long amount);
}
