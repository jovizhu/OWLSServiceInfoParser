package parser;

import java.util.ArrayList;

public class ServiceInfo {

	public String serviceDescription;

	public ArrayList<IONode> serviceInput;
	public ArrayList<IONode> serviceOutput;
	public ArrayList<IONode> servicePrecondition;
	public ArrayList<IONode> serviceEffect;
	public ArrayList<IONode> serviceLocal;

	public ServiceInfo() {
		super();
		this.serviceDescription = new String();
		this.serviceInput = new ArrayList<IONode>();
		this.serviceOutput = new ArrayList<IONode>();
		this.servicePrecondition = new ArrayList<IONode>();
		this.serviceEffect = new ArrayList<IONode>();
		this.serviceLocal = new ArrayList<IONode>();
		// TODO Auto-generated constructor stub
	}

	public ServiceInfo(String serviceDescription,
			ArrayList<IONode> serviceInput, ArrayList<IONode> serviceOutput,
			ArrayList<IONode> servicePrecondition,
			ArrayList<IONode> serviceEffect, ArrayList<IONode> serviceLocal) {
		super();
		this.serviceDescription = serviceDescription;
		this.serviceInput = serviceInput;
		this.serviceOutput = serviceOutput;
		this.servicePrecondition = servicePrecondition;
		this.serviceEffect = serviceEffect;
		this.serviceLocal = serviceLocal;
	}

	public ArrayList<IONode> getServiceInput() {
		return serviceInput;
	}

	public void addServiceInput(IONode serviceInput) {
		this.serviceInput.add(serviceInput);
	}

	public ArrayList<IONode> getServiceOutput() {
		return serviceOutput;
	}

	public void addServiceOutput(IONode serviceOutput) {
		this.serviceOutput.add(serviceOutput);
	}

	public ArrayList<IONode> getServicePrecondition() {
		return servicePrecondition;
	}

	public void addServicePrecondition(IONode servicePrecondition) {
		this.servicePrecondition.add(servicePrecondition);
	}

	public ArrayList<IONode> getServiceEffect() {
		return serviceEffect;
	}

	public void addServiceEffect(IONode serviceEffect) {
		this.serviceEffect.add(serviceEffect);
	}

	public ArrayList<IONode> getServiceLocal() {
		return serviceLocal;
	}

	public void addServiceLocal(IONode serviceLocal) {
		this.serviceLocal.add(serviceLocal);
	}

	public void setServiceLocal(ArrayList<IONode> serviceLocal) {
		this.serviceLocal = serviceLocal;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String serviceName;

}
