package org.redrock.MyExceptions;

/**
 * @author wang
 *
 */
public class Parcel_4 {
	private Object[][] fields;
	public Parcel_4(int initialSize) {
		fields = new Object[initialSize][2];
		for (int i = 0; i < initialSize; i++) {
			fields[i] = new Object[] {null, null};
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Object[] obj : fields) {
			result.append(obj[0]);
			result.append(": ");
			result.append(obj[1]);
			result.append("\n");
		}
		
		return result.toString();
	}
	
	private int hasField(String id) {
		for(int i = 0; i < fields.length; i++) {
			if(id.equals(fields[i][0]))
				return i;
		}
		
		return -1;
	}
	
	private int getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);
		if(fieldNum == -1)
			throw new NoSuchFieldException();
		
		return fieldNum;
	}
	
	private int makeField(String id) {
		for (int i = 0; i < fields.length; i++) {
			if (fields[i][0] == null) {
				fields[i][0] = id;
				return i;
			}
		}
		Object[][] tmp = new Object[fields.length + 1][2];
		for (int i= 0; i < fields.length; i++)
			tmp[i] = fields[i];
		for (int i = fields.length; i < tmp.length; i++)
			tmp[i] = new Object[] {null, null};
		
		fields = tmp;
		return makeField(id);
	}
	
	public Object getField(String id) throws NoSuchFieldException {
		return fields[getFieldNumber(id)][1];
	}
	
	public Object SetField(String id, Object value) throws DynamicFieldsException {
		if (value == null) {
			DynamicFieldsException def = new DynamicFieldsException();
			//���ｫ����һ���쳣�����������һ�����Դ��γ��쳣��
			def.initCause(new NullPointerException());
			throw def;
		}
		int fieldNumber = hasField(id);
		if (fieldNumber == -1)
			fieldNumber = makeField(id);
		
		//System.out.println(fieldNumber);
		Object result = null;
		try {
			result = getField(id);
		} catch(NoSuchFieldException e) {
			throw new RuntimeException(e);
		}
		fields[fieldNumber][1] = value;
		return result;
	}
	
	public static void main(String[] args) {
		Parcel_4 p = new Parcel_4(3);
		System.out.println(p);
		try {
			p.SetField("d", "A value for d");
			p.SetField("number", 47);
			p.SetField("number2", 48);
			System.out.println(p);
			p.SetField("d", "A new value for d");
			p.SetField("number3", 11);
			System.out.println(p);
			System.out.println(p.getField("d"));
			Object field = p.SetField("d", null);
		} catch(NoSuchFieldException e) {
			e.printStackTrace(System.out);
		} catch(DynamicFieldsException e) {
			e.printStackTrace(System.out);
		}
	}
}

class DynamicFieldsException extends Exception {}

