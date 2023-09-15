package model.dao;

public class SampleDao extends Dao{
	private static SampleDao sampleDao = new SampleDao();
	public static SampleDao getInstence() {return sampleDao;}
	private SampleDao() {}
	
	
	
	
}
