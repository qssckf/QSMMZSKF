package nc.qs.ws.app.pub;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import antlr.collections.List;
import com.yonyou.uap.um.json.MAJSONObject;

import nc.qs.ws.app.exception.AppRuntimeException;
import nc.vo.pm.util.StringUtil;

public class ContextUtil {
	
	public static reqData Parse(String req){
		
		reqData rd=new reqData();
		
		if (req == null) req = "{}";

		try {
			
			JSONObject jsonData = new JSONObject(req);
			
			String appid = jsonData.getString("appid");	
			String id = jsonData.getString("id");	
			JSONObject param=jsonData.getJSONObject("reqParams");
			
			rd.setAppid(appid);
			rd.setServiceid(id);
			rd.setParams(param);

			if(StringUtil.isEmpty(appid)){
				throw new AppRuntimeException("0", "error!appid is null!");
			}
			
			if(StringUtil.isEmpty(id)){
				throw new AppRuntimeException("0", "error!service id is null!");
			}
			
		} catch (JSONException e) {
			// TODO �Զ����ɵ� catch ��
			throw new AppRuntimeException("0",e,"json parse error!request data not json type!Please check it! json string:"+req);
		}
			
		return rd;

	}
	
	public static Map<String, String[]> convertParams(String paramsStr,String key,String value){
		
		Map<String, String[]> map = new HashMap();
		
		if (paramsStr.startsWith("|")) {
			paramsStr = paramsStr.subSequence(1, paramsStr.length()).toString();
		}
		if (paramsStr.endsWith("|")) {
			paramsStr = paramsStr.substring(0, paramsStr.length() - 1);
		}
		
		String[] paramsStrs = paramsStr.split("\\|");
		
		String[] nameStrs = new String[paramsStrs.length];
		String[] typeStrs = new String[paramsStrs.length];
		if (paramsStr.length() > 1) {
			int i = 0;
			for (String keyStr : paramsStrs) {
				String[] keyStrs = keyStr.split(":");
				nameStrs[i] = keyStrs[0].trim();
				typeStrs[i] = keyStrs[1].trim();
				i++;
			}
		}
		map.put(key, nameStrs);
		map.put(value, typeStrs);
		return map;
	}
	
	public static Class[] getMethodClasses(String[] typeStrs){
		
		Class[] classes = new Class[typeStrs.length];
		int i = 0;
		for (String keyStr : typeStrs) {
			classes[i] = getJavaClass(keyStr);
			i++;
		}
		
		return classes;
		
	}

	private static Class getJavaClass(String type) throws AppRuntimeException {
		// TODO �Զ����ɵķ������
		
		if ("string".equalsIgnoreCase(type))
			return String.class;
		if ("long".equalsIgnoreCase(type))
			return Long.TYPE;
		if ("int".equalsIgnoreCase(type))
			return Integer.TYPE;
		if ("float".equalsIgnoreCase(type))
			return Float.TYPE;
		if ("double".equalsIgnoreCase(type))
			return Double.TYPE;
		if ("string[]".equalsIgnoreCase(type))
			return java.lang.String[].class;
		if ("long[]".equalsIgnoreCase(type))
			return Long[].class;
		if ("int[]".equalsIgnoreCase(type))
			return int[].class;
		if ("float[]".equalsIgnoreCase(type))
			return float[].class;
		if ("double[]".equalsIgnoreCase(type))
			return double[].class;
		if ("boolean".equalsIgnoreCase(type))
			return Boolean.TYPE;
		if ("boolean[]".equalsIgnoreCase(type))
			return boolean[].class;
		if ("list".equalsIgnoreCase(type))
			return List.class;
		if ("map".equalsIgnoreCase(type))
			return Map.class;
		if ("json".equalsIgnoreCase(type))
			return JSONObject.class;
		if ((type == null) || ("null".equalsIgnoreCase(type))) {
			return null;
		}
		
		try
		{
			return Class.forName(type);
		}catch (ClassNotFoundException e) {
			throw new AppRuntimeException("0",e,"param define Class not found!");
		}
	}

	public static Object[] getMethodObjects(String[] nameStrs, JSONObject params) {
		// TODO �Զ����ɵķ������
	
		Object[] objects = new Object[nameStrs.length];
		String str="";
		
		try {
			int i = 0;

			if(params!=null&&params.length()>0){
				for(String namekey:nameStrs){
					for(Iterator its = params.keys();its.hasNext();){
						Object key=its.next();
						if(key.toString().equalsIgnoreCase(namekey)){
							
									objects[i]=params.get(key.toString());
									
									str=str+"|"+params.get(key.toString());
									
									break;
								
								
							

						}
					}
				i++;
			}
		
		}

		}catch (JSONException e) {
			// TODO �Զ����ɵ� catch ��
			throw new AppRuntimeException("0",e,e.getMessage());
		}
			
		return objects;
	}
	
	public static String processErr(Exception e){
		
		
		String errmsg=e.getMessage();
		String retStr;
		
		MAJSONObject retObj = new MAJSONObject();
		
		try{
		
		if(e instanceof AppRuntimeException){
			retObj.put("retCode", ((AppRuntimeException)e).getCode());
			retObj.put("retMsg", ((AppRuntimeException)e).getMsg());
			retObj.put("retObj", "{}");
		}else{
			retObj.put("retCode", "0");
			retObj.put("retMsg", e.getMessage());
			retObj.put("retObj", "{}");
		}
		
		retStr=retObj.toString();
			
		}catch(JSONException ex){
			return "{\"retCode\":\"0\",\"retMsg\":\"���ش�����Ϣʱjsonת������\",\"retObj\":{}}";
		}
		
		
		
		return retStr;
	}

	public static String processSuccessfuly(JSONArray obj) {
		
		JSONObject retObj = new JSONObject();
		try {
			
			
				retObj.put("retCode","1");
				retObj.put("retMsg", "successfuly");
				retObj.put("retObj", obj);
				
				return retObj.toString();

		
		} catch (JSONException e) {
			// TODO �Զ����ɵ� catch ��
			return "{\"retCode\":\"0\",\"retMsg\":\"���سɹ���Ϣʱjsonת������\",\"retObj\":{}}";
		}
		

		
	}
	
	

}
