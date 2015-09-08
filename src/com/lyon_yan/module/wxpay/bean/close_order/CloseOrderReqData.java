package com.lyon_yan.module.wxpay.bean.close_order;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.lyon_yan.module.wxpay.config.Configure;
import com.lyon_yan.module.wxpay.core.RandomStringGenerator;
import com.lyon_yan.module.wxpay.core.Signature;

@SuppressWarnings("serial")
public class CloseOrderReqData  implements Serializable {

	/**
	 * 
	 */
	private String appid = "";
	private String mch_id = "";
	private String out_trade_no = "";
	private String nonce_str = "";
	private String sign  = "";

	public CloseOrderReqData( 
			String out_trade_no) {
		super();
		setAppid(Configure.getAppid());
		setMch_id(Configure.getMchid());
		this.out_trade_no = out_trade_no;
		setNonce_str(RandomStringGenerator.getRandomStringByLength(32));
		// 根据API给的签名规则进行签名
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


	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object obj;
			try {
				obj = field.get(this);
				if (obj != null && !obj.toString().equals("")) {
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
