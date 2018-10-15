#pragma once
#include "YNCommon.ice"

module YN {
	interface IUserManager;
	interface ISystemConfig;
	interface ISystemControl;
	interface ISystemInformation;
	interface IDeviceManager;
	
	// YN服务接口
	interface IService {
		Result login(string username, string password);
		
		Result logout();
		
		Result getLoggedUserInfo(out string userName, out UserType userType, out string loginTime);
		
		Result getSiteList(out string jsonText);
		
		Result getUserManager(out IUserManager userMgr);

		Result getSystemConfig(out ISystemConfig sysCfg);

		Result getSystemControl(out ISystemControl sysCtrl);

		Result getSystemInformation(out ISystemInformation si);

		Result getDeviceManager(out IDeviceManager devMgr);
	};

	// 用户管理接口
	interface IUserManager {
		Result addUser(string userName, string password, UserType userType);
		
		Result delUser(string userName);
		
		Result getAllUser(out UserInfoList userName);
	};
	
	// 系统配置接口
	interface ISystemConfig {
		Result getSystemName(out string userName);
		Result setSystemName(string userName);
		
		Result getRedundancyAddr (out bool isEnabled, out StringList ipList);
		Result setRedundancyAddr (bool isEnabled, StringList ipList);
		
		Result getEthAddr (out EthInfoList ethInfoList);
		Result setEthAddr (EthInfoList ethInfoList);
	};
	
	// 系统操控接口
	interface ISystemControl {
		Result startProject(string projName);

		Result stopProject();
		
		Result restartProject();
		
		Result upProject(string localProjPath, string remoteProjName);
		
		Result downProject(string remoteProjName, string localProjPath);
	};
	
	// 设备管理接口
	interface IDeviceManager {
		Result getDeviceList(out DeviceInfoList devList);
	
		Result getDevicePointCount(string devName, out int ptCnt);

		Result getDevicePointList(string devName, int offset, int recordLimit, out PointInfoList ptList);
	};

	// 数据管理接口
	interface IDataMonitor {
		Result queryDeviceState(StringList deviceNameList, out DeviceStateList stateList);
		
		Result queryRealData(PointIdList ptIdList, out VqtList valueList, out ResultList results);
	
		Result queryCommunicationMessage(string devName, int inMsgId, int recordLimit, out StringList msgs, out int outMsgId);
		
		Result querySystemLog(int inLogId, int recordLimit, out StringList msgs, out int outLogId);
	};

	// 系统信息接口
	interface ISystemInformation {
		Result getCpuUsageRate(out double usageRate);

		Result getStorageDeviceInfo(out StorageDeviceInfoList sdiList);
	};
};
