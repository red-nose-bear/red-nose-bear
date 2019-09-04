import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@AllArgsConstructor
@Getter
public enum ReceiveOrderStatusEnum {

    DUE(150, "妥投", "已签收"),
    REJECT(160, "拒收", "已拒收"),
    FORCED_DUE(290, "正常运单强制完成", "已签收"),
    AFTER_SALE_ORDER_CANCEL(460, "售后订单终止", "已取消"),
    AFTER_SALE_ORDER_FORCED_DUE(470, "售后订单强制完成", "已签收"),
    RETURN_TRADER_CONFIRM(530, "退货到商家确认(上门接货退货完成)", "已取消"),
    RETURN_COMPLETE(540, "退货完成", "已签收"),
    PARTLY_DUE(600, "部分签收(运单)", "部分签收"),
    SYSTEM_AUTO_COMPLETE(-151, "系统自动完成", "已签收"),
    VILLAGER_SIGN(-410, "村民签收", "已签收"),
    VILLAGER_REJECT(-420, "村民拒收", "已拒收"),
    PROMOTER_PICK_UP_TERMINATION(-440, "推广员取件终止", "已取消"),
    PICK_UP_TERMINATION(-650, "终止揽收", "已取消"),
    DELIVERY_ABNORMAL_TERMINATION(-680, "配送异常终止", "已取消"),
    ORDER_FAILED(-780, "下单失败", "已取消"),
    ORDER_CANCEL(-790, "下单取消", "已取消"),
    PAY(-840, "赔付", "已签收"),
    INTERCEPT(-860, "拦截成功", "已取消"),
    SIGN(-970, "签收", "已签收"),
    CROWD_GRAB_ORDER_TIME_OUT(-1250, "众包超时未抢单", "已取消"),
    CONVENIENT_RECEIVE_RETURN_GOODS(-1320, "便民点收货退货", "已取消"),
    APPLY_FOR_REFUND_SUCCESS(-1470, "申请退款成功", "已取消"),
    REFUND_SUCCESS(-1480, "退款成功", "已取消"),
    O2O_REJECT_RETURN(-1490, "O2O拒收退回", "已取消");

    /**
     * 运单状态码
     */
    private Integer statusCode;
    /**
     * 运单状态描述
     */
    private String etmsDesc;
    /**
     * 移动描述
     */
    private String mrdDesc;

    /**
     * 可删除订单的状态
     */
    private static final List<String> deletableList = new ArrayList<>();

    /**
     * 保存全量enum的Map
     */
    private static final Map<Integer, ReceiveOrderStatusEnum> receiveOrderStatusMap = new HashMap<>();

    /**
     * 判断入参对应状态的订单是否显示删单入口
     * @param code
     * @return
     */
    public static final boolean isDeletable(Integer code) {
        if (receiveOrderStatusMap.containsKey(code) && deletableList.contains(receiveOrderStatusMap.get(code).getMrdDesc()))
            return true;

        return false;
    }

    static {

        for (ReceiveOrderStatusEnum statusEnum : EnumSet.allOf(ReceiveOrderStatusEnum.class)) {
            receiveOrderStatusMap.put(statusEnum.getStatusCode(), statusEnum);
        }

        deletableList.addAll(Arrays.asList("已签收", "已拒收", "已取消", "部分签收"));

    }

    public static void main(String[] args) {
        isDeletable(530);
    }

}
