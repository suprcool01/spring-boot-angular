package com.javacodegeeks.examples.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ticket {

	@Id
	private String id;
	private String name;
	private String dateTime;
	private String customer;

	private String stage;
	private String url;
	private String serversToPatch;
	private String connection;
	private String installationPath;
	
	private List<String> previousPackages;
	
	private List<String> patchingVersions;
	
	private String manualTaskBeforePatch;
	private String manualTaskAfterPatch;
	private String manualTaskBeforeRollback;
	private String manualTaskAfterRollback;
	private String checkedPreviousDeploymentPlan;
	
	private String customerApprovedPreDep;
	private String customerApprovedPostDep;
	
	private String frontEndLoadsPreDep;
	private String frontEndLoadsPostDep;
	
	private String controlCentreLoadsPreDep;
	private String controlCentreLoadsPostDep;
	
	private String galaxiesLoadsPreDep;
	private String galaxiesLoadsPostDep;
	
	private String friendlyUrlPreDep;
	private String friendlyUrlPostDep;
	
	private String homePageLoadsPreDep;
	private String homePageLoadsPostDep;
	
	private String ckEditorLoadsPreDep;
	private String ckEditorLoadsPostDep;
	
	private String scheduleTasksPreDep;
	private String scheduleTasksPostDep;
	
	private String xPFSymfonyLoadPreDep;
	private String xPFSymfonyLoadPostDep;
	
	private String xPFFormsLoadPreDep;
	private String xPFFormsLoadPostDep;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getStage() {
		return this.stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServersToPatch() {
		return serversToPatch;
	}

	public void setServersToPatch(String serversToPatch) {
		this.serversToPatch = serversToPatch;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getInstallationPath() {
		return installationPath;
	}

	public void setInstallationPath(String installationPath) {
		this.installationPath = installationPath;
	}

	public List<String> getPreviousPackages() {
		return previousPackages;
	}

	public void setPreviousPackages(List<String> previousPackages) {
		this.previousPackages = previousPackages;
	}

	public List<String> getPatchingVersions() {
		return patchingVersions;
	}

	public void setPatchingVersions(List<String> patchingVersions) {
		this.patchingVersions = patchingVersions;
	}

	public String getManualTaskBeforePatch() {
		return manualTaskBeforePatch;
	}

	public void setManualTaskBeforePatch(String manualTaskBeforePatch) {
		this.manualTaskBeforePatch = manualTaskBeforePatch;
	}

	public String getManualTaskAfterPatch() {
		return manualTaskAfterPatch;
	}

	public void setManualTaskAfterPatch(String manualTaskAfterPatch) {
		this.manualTaskAfterPatch = manualTaskAfterPatch;
	}

	public String getManualTaskBeforeRollback() {
		return manualTaskBeforeRollback;
	}

	public void setManualTaskBeforeRollback(String manualTaskBeforeRollback) {
		this.manualTaskBeforeRollback = manualTaskBeforeRollback;
	}

	public String getManualTaskAfterRollback() {
		return manualTaskAfterRollback;
	}

	public void setManualTaskAfterRollback(String manualTaskAfterRollback) {
		this.manualTaskAfterRollback = manualTaskAfterRollback;
	}

	public String getCheckedPreviousDeploymentPlan() {
		return checkedPreviousDeploymentPlan;
	}

	public void setCheckedPreviousDeploymentPlan(String checkedPreviousDeploymentPlan) {
		this.checkedPreviousDeploymentPlan = checkedPreviousDeploymentPlan;
	}

	public String getCustomerApprovedPreDep() {
		return customerApprovedPreDep;
	}

	public void setCustomerApprovedPreDep(String customerApprovedPreDep) {
		this.customerApprovedPreDep = customerApprovedPreDep;
	}

	public String getCustomerApprovedPostDep() {
		return customerApprovedPostDep;
	}

	public void setCustomerApprovedPostDep(String customerApprovedPostDep) {
		this.customerApprovedPostDep = customerApprovedPostDep;
	}

	public String getFrontEndLoadsPreDep() {
		return frontEndLoadsPreDep;
	}

	public void setFrontEndLoadsPreDep(String frontEndLoadsPreDep) {
		this.frontEndLoadsPreDep = frontEndLoadsPreDep;
	}

	public String getFrontEndLoadsPostDep() {
		return frontEndLoadsPostDep;
	}

	public void setFrontEndLoadsPostDep(String frontEndLoadsPostDep) {
		this.frontEndLoadsPostDep = frontEndLoadsPostDep;
	}

	public String getControlCentreLoadsPreDep() {
		return controlCentreLoadsPreDep;
	}

	public void setControlCentreLoadsPreDep(String controlCentreLoadsPreDep) {
		this.controlCentreLoadsPreDep = controlCentreLoadsPreDep;
	}

	public String getControlCentreLoadsPostDep() {
		return controlCentreLoadsPostDep;
	}

	public void setControlCentreLoadsPostDep(String controlCentreLoadsPostDep) {
		this.controlCentreLoadsPostDep = controlCentreLoadsPostDep;
	}

	public String getGalaxiesLoadsPreDep() {
		return galaxiesLoadsPreDep;
	}

	public void setGalaxiesLoadsPreDep(String galaxiesLoadsPreDep) {
		this.galaxiesLoadsPreDep = galaxiesLoadsPreDep;
	}

	public String getGalaxiesLoadsPostDep() {
		return galaxiesLoadsPostDep;
	}

	public void setGalaxiesLoadsPostDep(String galaxiesLoadsPostDep) {
		this.galaxiesLoadsPostDep = galaxiesLoadsPostDep;
	}

	public String getHomePageLoadsPreDep() {
		return homePageLoadsPreDep;
	}

	public void setHomePageLoadsPreDep(String homePageLoadsPreDep) {
		this.homePageLoadsPreDep = homePageLoadsPreDep;
	}

	public String getHomePageLoadsPostDep() {
		return homePageLoadsPostDep;
	}

	public void setHomePageLoadsPostDep(String homePageLoadsPostDep) {
		this.homePageLoadsPostDep = homePageLoadsPostDep;
	}

	public String getCkEditorLoadsPreDep() {
		return ckEditorLoadsPreDep;
	}

	public void setCkEditorLoadsPreDep(String ckEditorLoadsPreDep) {
		this.ckEditorLoadsPreDep = ckEditorLoadsPreDep;
	}

	public String getCkEditorLoadsPostDep() {
		return ckEditorLoadsPostDep;
	}

	public void setCkEditorLoadsPostDep(String ckEditorLoadsPostDep) {
		this.ckEditorLoadsPostDep = ckEditorLoadsPostDep;
	}

	public String getScheduleTasksPreDep() {
		return scheduleTasksPreDep;
	}

	public void setScheduleTasksPreDep(String scheduleTasksPreDep) {
		this.scheduleTasksPreDep = scheduleTasksPreDep;
	}

	public String getScheduleTasksPostDep() {
		return scheduleTasksPostDep;
	}

	public void setScheduleTasksPostDep(String scheduleTasksPostDep) {
		this.scheduleTasksPostDep = scheduleTasksPostDep;
	}

	public String getxPFSymfonyLoadPreDep() {
		return xPFSymfonyLoadPreDep;
	}

	public void setxPFSymfonyLoadPreDep(String xPFSymfonyLoadPreDep) {
		this.xPFSymfonyLoadPreDep = xPFSymfonyLoadPreDep;
	}

	public String getxPFSymfonyLoadPostDep() {
		return xPFSymfonyLoadPostDep;
	}

	public void setxPFSymfonyLoadPostDep(String xPFSymfonyLoadPostDep) {
		this.xPFSymfonyLoadPostDep = xPFSymfonyLoadPostDep;
	}

	public String getxPFFormsLoadPreDep() {
		return xPFFormsLoadPreDep;
	}

	public void setxPFFormsLoadPreDep(String xPFFormsLoadPreDep) {
		this.xPFFormsLoadPreDep = xPFFormsLoadPreDep;
	}

	public String getxPFFormsLoadPostDep() {
		return xPFFormsLoadPostDep;
	}

	public void setxPFFormsLoadPostDep(String xPFFormsLoadPostDep) {
		this.xPFFormsLoadPostDep = xPFFormsLoadPostDep;
	}

	public String getFriendlyUrlPreDep() {
		return friendlyUrlPreDep;
	}

	public void setFriendlyUrlPreDep(String friendlyUrlPreDep) {
		this.friendlyUrlPreDep = friendlyUrlPreDep;
	}

	public String getFriendlyUrlPostDep() {
		return friendlyUrlPostDep;
	}

	public void setFriendlyUrlPostDep(String friendlyUrlPostDep) {
		this.friendlyUrlPostDep = friendlyUrlPostDep;
	}

}
