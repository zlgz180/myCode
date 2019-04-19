package com.notes;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author tianwei
 * @since 2019-04-19 15:48
 */
public class AccountOperationManager {

    /**
     * 扣款
     * @param transferDTO
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Throwable.class)
    @Override
    public Boolean decrease(TransferDTO transferDTO) throws Exception{
        //使用transactionId设为唯一约束，用来做幂等性
        try{
            transferMoneyMapper.saveRecord(transferDTO);
        } catch (Exception e){
            return true;//已经发送过
        }

        //扣款(versionId + 1)
        transferMoneyMapper.decrease(transferDTO.getPayAccountId(), transferDTO.getAmount(), accountInfo.getVersionId());

        //扣款成功修改转账记录表状态值为1
        transferMoneyMapper.updateStatus(transferDTO.getTransactionId(), 0, 1);
        return false;
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void increase(TransferDTO transferDTO) throws Exception{
        //付款
        transferMoneyMapper.increase(transferDTO.getRecAccountId(), transferDTO.getAmount());

        //更新状态为1的记录
        Integer count = transferMoneyMapper.updateStatus(transferDTO.getTransactionId(), 1, 2);
        if (count != 1){
            throw new Exception("付款失败！");
        }
    }
}
