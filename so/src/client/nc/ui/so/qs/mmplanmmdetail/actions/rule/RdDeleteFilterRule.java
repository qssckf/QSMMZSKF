package nc.ui.so.qs.mmplanmmdetail.actions.rule;

import java.util.ArrayList;
import java.util.List;

import nc.itf.so.qs.sc.base.IFilterRule;
import nc.so.qs.sc.bs.bd.service.ErrLogElement;
import nc.so.qs.sc.bs.bd.service.ValueObjWithErrLog;
import nc.vo.pub.SuperVO;
import nc.vo.so.qs.sc.en.Billstatus;

public class RdDeleteFilterRule implements IFilterRule{

	@Override
	public ValueObjWithErrLog process(ValueObjWithErrLog vos) {
		// TODO �Զ����ɵķ������
		
		List<SuperVO> newVos=new ArrayList();
		
		for(SuperVO vo:vos.getVos()){
			
			if((Integer)vo.getAttributeValue("billstatus")==1){
				newVos.add(vo);
			}else{
				vos.getErrLogList().add(new ErrLogElement(vo,"���ݲ�Ϊ��ʼ��״̬������ɾ����"));
			}
			
		}
		
		vos.setVos(newVos.toArray(new SuperVO[0]));
		
		return vos;
		
	}
	
	

}
