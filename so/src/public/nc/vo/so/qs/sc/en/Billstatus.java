package nc.vo.so.qs.sc.en;

import nc.md.model.IEnumValue;
import nc.md.model.impl.MDEnum;

public class Billstatus extends MDEnum{

	public Billstatus(IEnumValue enumValue) {
		super(enumValue);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public static final Billstatus INIT = MDEnum.valueOf(Billstatus.class, String.valueOf("1"));
	
	
	public static final Billstatus READY = MDEnum.valueOf(Billstatus.class, String.valueOf("2"));
	
	public static final Billstatus FINISH = MDEnum.valueOf(Billstatus.class, String.valueOf("3"));

}
