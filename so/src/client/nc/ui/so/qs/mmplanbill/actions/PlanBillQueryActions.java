package nc.ui.so.qs.mmplanbill.actions;

import java.awt.Event;

import javax.swing.Action;
import javax.swing.KeyStroke;

import nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction;

public class PlanBillQueryActions extends DefaultQueryAction{

	public PlanBillQueryActions(){
		
		super();
		
		this.setBtnName("��ѯ����������Ϣ");
		this.putValue("AcceleratorKey", KeyStroke.getKeyStroke((int)'P', Event.ALT_MASK));
		this.putValue(Action.SHORT_DESCRIPTION, "��ѯ_����������Ϣ (ALT+P)");
		
	}

	@Override
	protected void showQueryInfo() {
		// TODO �Զ����ɵķ������
	}
	
	
}
