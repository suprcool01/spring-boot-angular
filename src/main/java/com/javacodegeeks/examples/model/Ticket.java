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

}
