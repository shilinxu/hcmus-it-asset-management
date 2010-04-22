package hcmus.am.client;

 import com.smartgwt.client.data.DSRequest;  
 import com.smartgwt.client.data.DataSource;  
 import com.smartgwt.client.data.fields.DataSourceImageField;  
 import com.smartgwt.client.data.fields.DataSourceIntegerField;  
 import com.smartgwt.client.data.fields.DataSourceTextField;  
   
 public class EquipmentXmlDS extends DataSource {  
   
     private static EquipmentXmlDS instance = null;  
   
     public static EquipmentXmlDS getInstance() {  
         if (instance == null) {  
             instance = new EquipmentXmlDS("equipmentDS");  
         }  
         return instance;  
     }  
   
     public EquipmentXmlDS(String id) {  
   
         setID(id);  
         setRecordXPath("/List/Object");  
         DataSourceTextField commonNameField = new DataSourceTextField("commonName", "Animal");  
   
         DataSourceTextField scientificName = new DataSourceTextField("scientificName", "Scientific Name");  
         scientificName.setRequired(true);  
         scientificName.setPrimaryKey(true);
   
         DataSourceIntegerField lifeSpanField = new DataSourceIntegerField("lifeSpan", "Life Span");  
   
         DataSourceTextField statusField = new DataSourceTextField("status", "Available Status");  
         statusField.setValueMap("Available", "Broken", "Repaired", "Borrowed"); 
   
         DataSourceTextField dietField = new DataSourceTextField("diet", "Diet");  
   
         DataSourceTextField infoField = new DataSourceTextField("information", "Interesting Facts");  
         infoField.setLength(1000);  
   
         DataSourceImageField pictureField = new DataSourceImageField("picture", "Picture");  
         pictureField.setImageURLPrefix("animals/");  
   
         setFields(commonNameField, scientificName, lifeSpanField, statusField, dietField, infoField, pictureField);  
   
         setDataURL("ds/test_data/equipment.data.xml");  
         setClientOnly(true);  
     }  
   
     /** 
      * Override transformRequest. Here for illustration purposes only and this override implementation simply calls 
      * super.transformReRequest 
      * 
      * @param dsRequest the DSRequest being processed 
      * @return the transformed request 
      */  
     @Override  
     protected Object transformRequest(DSRequest dsRequest) {  
         return super.transformRequest(dsRequest);  
     }  
 }  