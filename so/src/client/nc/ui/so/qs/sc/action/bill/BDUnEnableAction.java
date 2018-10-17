package nc.ui.so.qs.sc.action.bill;

import nc.ui.bd.pub.actions.ManageModeActionInterceptor;
import nc.ui.uif2.actions.ActionInterceptor;
import nc.ui.uif2.actions.CompositeActionInterceptor;
import nc.ui.uif2.model.AbstractAppModel;

public abstract class BDUnEnableAction extends UnEnableAction {

	private ManageModeActionInterceptor manageModeActionInterceptor = new ManageModeActionInterceptor();
	
	private CompositeActionInterceptor interceptor;
	
	public BDUnEnableAction(){
		
		this.interceptor = new CompositeActionInterceptor();
		super.setInterceptor(this.interceptor);
		this.interceptor.add(this.manageModeActionInterceptor);
		setInterceptor(this.manageModeActionInterceptor);
		
	}
	
	public void setInterceptor(ActionInterceptor interceptor){
		this.interceptor.add(interceptor);
	}
	
	public void setModel(AbstractAppModel model){
		super.setModel(model);
		this.manageModeActionInterceptor.setModel(model);
	}

}
