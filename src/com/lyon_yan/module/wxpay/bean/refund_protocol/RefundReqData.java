package com.lyon_yan.module.wxpay.bean.refund_protocol;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.lyon_yan.module.wxpay.config.Configure;
import com.lyon_yan.module.wxpay.core.RandomStringGenerator;
import com.lyon_yan.module.wxpay.core.Signature;

/**
 * 
 * @author Lyon
 *
 */
@SuppressWarnings("serial")
public class RefundReqData  implements Serializable{

    /**
	 * 
	 */
	//每个字段具体的意思请查看API文档
    private String appid = "";
    private String mch_id = "";
    private String device_info = "";
    private String nonce_str = "";
    private String sign = "";
    private String transaction_id = "";
    private String out_trade_no = "";
    private String out_refund_no = "";
    private int total_fee = 0;
    private int refund_fee = 0;
    private String refund_fee_type = "CNY";
    private String op_user_id = "";

    public RefundReqData(String transactionID,String outTradeNo,String deviceInfo,String outRefundNo,int totalFee,int refundFee,String opUserID,String refundFeeType){
        setAppid(Configure.getAppid());
        setMch_id(Configure.getMchid());
        setTransaction_id(transactionID);
        setOut_trade_no(outTradeNo);
        setDevice_info(deviceInfo);

        setOut_refund_no(outRefundNo);

        setTotal_fee(totalFee);

        setRefund_fee(refundFee);

        setOp_user_id(opUserID);
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
        String sign = Signature.getSign(toMap());
        setSign(sign);

    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public int getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(int refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getOp_user_id() {
        return op_user_id;
    }

    public void setOp_user_id(String op_user_id) {
        this.op_user_id = op_user_id;
    }

    public String getRefund_fee_type() {
        return refund_fee_type;
    }

    public void setRefund_fee_type(String refund_fee_type) {
        this.refund_fee_type = refund_fee_type;
    }

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object obj;
			try {
				obj = field.get(this);
				if (obj != null&&!obj.toString().equals("")) {
					map.put(field.getName(), obj);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}
