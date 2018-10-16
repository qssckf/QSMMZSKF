package nc.bs.so.qs.sc.plugin;

import nc.impl.pubapp.pattern.rule.plugin.IPluginPoint;

public enum PBPluginPoint implements IPluginPoint{
	
	DELETE,  INSERT,  UPDATE,  EXEC, UNEXEC ;
	
	
	
	@Override
	public String getComponent() {
		// TODO �Զ����ɵķ������
		return "MmPlanBillVO";
	}

	@Override
	public String getModule() {
		// TODO �Զ����ɵķ������
		return "so";
	}

	@Override
	public String getPoint() {
		// TODO �Զ����ɵķ������
		return getClass().getName() + "." + name();
	}

}
