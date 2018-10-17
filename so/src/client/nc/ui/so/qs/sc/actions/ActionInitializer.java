package nc.ui.so.qs.sc.actions;

import nc.ui.uif2.NCAction;
import nc.ui.uif2.actions.ActionInfo;

public class ActionInitializer {
	
	public ActionInitializer(){}
	
	public static void initializeAction(NCAction action, String actionCode){
		
		ActionInfo info = ActionRegistry.getActionInfo(actionCode);
		action.setBtnName(info.getName());
		action.setCode(info.getCode());
		action.putValue("AcceleratorKey", info.getKeyStroke());
		action.putValue("ShortDescription", info.getShort_description());
		action.putValue("SmallIcon", info.getIcon());
		action.putValue("NameResdir", info.getDir());
		action.putValue("NameResid", info.getNameResid());
		
	}

}
