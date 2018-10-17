package nc.vo.so.qs.appinterface.query;

import nc.vo.so.qs.appinterface.util.BillQuery;
import nc.vo.so.qs.appinterface.util.IBillType;

public class PreOrderHanded implements IBillType{

	@Override
	public String getCategory() {
		// TODO �Զ����ɵķ������
		return "isPrehanded";
	}

	@Override
	public String getCode() {
		// TODO �Զ����ɵķ������
		return "Prehanded";
	}

	@Override
	public String getName() {
		// TODO �Զ����ɵķ������
		return "������";
	}

	@Override
	public BillQuery createNewTaskQuery() {
		// TODO �Զ����ɵķ������
		return new PreOrderQuery();
	}
	
	

}
