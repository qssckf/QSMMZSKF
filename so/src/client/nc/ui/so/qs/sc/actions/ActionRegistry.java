package nc.ui.so.qs.sc.actions;

import java.util.HashMap;
import java.util.Map;

import javax.swing.KeyStroke;

import nc.ui.uif2.actions.ActionInfo;
import nc.vo.jcom.lang.StringUtil;

public class ActionRegistry {
	
	private static Map<String, ActionInfo> actionMap = new HashMap();
	
	private static ActionInfo[] infos={new ActionInfo("UnEnable","取消启用", "取消启用(Alt+E)", null, getKeyStroke('E', 8))};
	
	static{
		for(ActionInfo info : infos){
			actionMap.put(info.getCode(), info);
		}
	}
	
	public static ActionInfo getActionInfo(String actionCode) {
		
		
		if (StringUtil.isEmptyWithTrim(actionCode)){
			return null;
		}
		
		return (ActionInfo)actionMap.get(actionCode);
		
	}
	
	private static KeyStroke getKeyStroke(char ch, int mask)
	{
		return KeyStroke.getKeyStroke(ch, mask);
	}
	

}
