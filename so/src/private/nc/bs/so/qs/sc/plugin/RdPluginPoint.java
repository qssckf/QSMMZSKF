package nc.bs.so.qs.sc.plugin;

import nc.impl.pubapp.pattern.rule.plugin.IPluginPoint;

public enum RdPluginPoint implements IPluginPoint{
	
	DELETE,  INSERT,  UPDATE, RELEASE,RDCREATEPMO,RDCREATEDMO;

	@Override
	public String getComponent() {
		// TODO �Զ����ɵķ������
		return "RdPorductDetailVO";
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
