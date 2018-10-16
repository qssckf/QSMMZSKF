package nc.ui.so.qs.mmplanmmdetail.actions;

import java.awt.Event;

import javax.swing.Action;
import javax.swing.KeyStroke;

import nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction;
import nc.uitheme.ui.ThemeResourceCenter;

public class RdQueryAction extends DefaultQueryAction{
	
	private final String iconurl="themeres/ui/toolbaricons/refer_file.png";
	
	public RdQueryAction(){
		
		super();
		
		this.setBtnName("��ѯ��������Ϣ");
		this.setCode("RdQuyer");
		this.putValue("ShortDescription", "��ѯ�������δ��������������¼");
		this.putValue("SmallIcon", ThemeResourceCenter.getInstance().getImage(iconurl));
		
	}

	@Override
	protected void showQueryInfo() {
		// TODO �Զ����ɵķ������
		
	}
	
	

}
