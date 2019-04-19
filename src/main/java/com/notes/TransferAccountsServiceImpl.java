package com.notes;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 接口facade
 */
public class TransferAccountsServiceImpl implements TransferAccountsService {
    /**
     * 业务管理
     */
    @Autowired
    private AccountOperationBiz accountOperationBiz;

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
    @Override
    public Result transferAccounts(TransferDTO transferDTO) {
        boolean result =false;
        try {
            // 入参校验
            if (StringUtils.isEmpty(transferDTO.getTransactionId()) || StringUtils.isEmpty(transferDTO.getAmount())
                    || StringUtils.isEmpty(transferDTO.getRecAccountId())
                    || StringUtils.isEmpty(transferDTO.getPayAccountId())) {
                return new Result(false, "参数为空！");
            }

            // 接口安全性校验
            // 增加接口授权token,通过token+请求内容+时间戳+随机数md5一个字符串（IdentityId），和服务器本地算出的是否一致，一致代表入参没被修改过
            Boolean flag = accountOperationService.identityCheck(transferDTO.getIdentityId(), transferDTO.getOrderId(),
                    transferDTO.getInUserId(),transferDTO.getOutUserId(),transferDTO.gettoken(),transferDTO.gettime(), transferDTO.getAmount());
            if (!flag) {
                // TODO 发送监控报警
                return new Result(false, "非法请求！");
            }
            result = accountOperationBiz.transferAccounts(transferDTO);
        } catch (Exception e) {
            return new Result(false, "转账失败！");
        }
        return new Result(result, "转账成功！");
    }

}
