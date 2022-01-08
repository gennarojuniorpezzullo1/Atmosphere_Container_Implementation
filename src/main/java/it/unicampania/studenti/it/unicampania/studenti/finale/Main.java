package it.unicampania.studenti.it.unicampania.studenti.finale;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1DeleteOptions;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.openapi.models.V1DeploymentList;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ApiException{
    	
    	 Scanner scan= new Scanner(System.in);
    	 
    	 int command=0;
    	
           
            		System.out.println("What do you want to do?\n"
                			+ "type 1 to watch pods\n"
                			+ "type 2 to watch deploymets\n"
                			+ "type 3 to create a deployment\n"
                			+ "type 4 to delete a pod\n"
                			+ "type 5 to delete a deployment\n");
            		   command= scan.nextInt();
                       
            
        	if(command==1) {
        		
                ApiClient client = Config.defaultClient();
                Configuration.setDefaultApiClient(client);

                CoreV1Api api = new CoreV1Api();
                V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
                for (V1Pod item : list.getItems()) {
                    System.out.println(item.getMetadata().getName());
                }
        	
        	}
        	if(command==2) {
        	      ApiClient client = Config.defaultClient();
        	        Configuration.setDefaultApiClient(client);

        	        AppsV1Api api = new AppsV1Api();
        	        V1DeploymentList list = api.listNamespacedDeployment("default", null, null, null, null, null, null, null, null, null);
        	        for (V1Deployment item : list.getItems()) {
        	            System.out.println(item.getMetadata().getName());
        	        }
            	
        	}
        	else if(command==3) {
        		

        		System.out.println("Write the name of the document \n");
        		String filename = scan.next();
        		
        		FileReader f;
        	    f=new FileReader(filename);

        	    BufferedReader b;
        	    b=new BufferedReader(f);
        	    String s;
        	    s=b.readLine();
        	    System.out.println(s);
        		    try {
        				      AppsV1Api api = new AppsV1Api(ClientBuilder.standard().build());
        				      V1Deployment body =
        				          Configuration.getDefaultApiClient()
        				              .getJSON()
        				              .deserialize(s, V1Deployment.class);

        				      V1Deployment deploy1 = api.createNamespacedDeployment("default", body, null, null, null);
        				      System.out.println("original deployment" + deploy1);
        				     
        				    } catch (ApiException e) {
        				      System.out.println(e.getResponseBody());
        				      e.printStackTrace();
        				    }
        				  }
        	
        	else if(command==4) {
        		System.out.println("Enter the name of the pod you want to delete");
        		String text_pods = scan.next();
        		
        		ApiClient client = Config.defaultClient();
        		Configuration.setDefaultApiClient(client);

        		CoreV1Api api = new CoreV1Api();
        		V1DeleteOptions v1DeleteOptions = new V1DeleteOptions();
        		v1DeleteOptions.setApiVersion("v1");

        		v1DeleteOptions.setOrphanDependents(true);
        		
        		//deleteNamespacedPod(String name, String namespace, String pretty, String dryRun, Integer gracePeriodSeconds, Boolean orphanDependents, String propagationPolicy, V1DeleteOptions body)
        			api.deleteNamespacedPod(text_pods, "default", null, null,null, null, null, v1DeleteOptions);
        		
        		   //V1Status v1Status = api.deleteNamespacedPod("hello-node","default", v1DeleteOptions, null, null, null , null , null);
        	//deleteNamespace(String name, String pretty, String dryRun, Integer gracePeriodSeconds, Boolean orphanDependents, String propagationPolicy, V1DeleteOptions body)

        		//	api.deleteNamespace("hello-node",null, null, null, null,null, null);
        				
        			
        	    } 
        	else if(command==5) {
        		System.out.println("Enter the name of the deploymet you want to delete");
        		String text_deployment = scan.next();
        		
        		
        		ApiClient client = Config.defaultClient();
        		Configuration.setDefaultApiClient(client);       	
        		AppsV1Api apps_api = new AppsV1Api();
        		V1DeleteOptions v1DeleteOptions = new V1DeleteOptions();
        		v1DeleteOptions.setApiVersion("v1");

        		v1DeleteOptions.setOrphanDependents(true);
 		
        	    apps_api.deleteNamespacedDeployment(text_deployment,"default", null,null,null, null, null, v1DeleteOptions);
        		
        			
        			
        		
        		
        	}
       
				  }
    	
    	
   
    
}


