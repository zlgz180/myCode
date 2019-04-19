package com.notes;

/**
 * @author tianwei
 * @since 2019-04-19 15:35
 */
public interface AccountOperationBiz {
    /**
     * 转账
     * @param transferDTO
     * @return
     */
    public boolean transferAccounts(TransferDTO transferDTO);
}
