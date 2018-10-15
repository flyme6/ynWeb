#pragma once

module YN {
	// 调用返回结果
	enum Result {
		OK,
		FAIL,
		INVALID_ARG,
		ACCESS_DENIED,
		ALREADY_EXISTED,
		NOT_FOUND,
		NOT_LOGGED,
		NOT_STARTED
	};
	
	// 定义用户类型
	enum UserType {
		ADMIN,		// 管理员
		ENGIN,		// 工程师
		OPERA		// 操作员
	};
		
	// 定义设备类型
	enum DeviceType {
		C_MODBUS_TCP,			// modbus TCP采集设备
		C_MODBUS_RTU,			// modbus RTU采集设备
		C_MODBUS_ASCII,			// modbus 文本采集设备
		C_MODBUS_TCP_RTU,		// modbus TCP通道的RTU采集设备
		C_MODBUS_TCP_ASCII,		// modbus TCP通道的文本采集设备
		C_IEC014,				// IEC104 采集设备
		C_ABCIP,				// ABCIP 采集设备
		F_MODBUS_TCP,			// modbus TCP转发设备
		F_MODBUS_RTU,			// modbus RTU转发设备
		F_MODBUS_ASCII,			// modbus 文本转发设备
		F_MODBUS_TCP_RTU,		// modbus TCP通道的RTU转发设备
		F_MODBUS_TCP_ASCII,		// modbus TCP通道的文本转发设备
		F_IEC014,				// IEC104 转发设备
	};
		
	// 定义数值类型
	enum VarType {
		EMPTY,		// null
		BOOL,		// boolean
		INT8,		// byte
		INT16,		// short
		INT32,		// int
		INT64,		// long
		REAL32,		// float
		REAL64,		// double
		STRING		// string
	};
		
	// 定义设备状态
	enum DeviceState {
		STOPED,			// 设备未运行
		RUNNING,		// 设备正常采集中
		OPENING,		// 设备打开过程中
	};

		
	// 定义值质量信息
	enum Quality {
		UNCERTAIN,		// 初始状态，未采集到数据
		GOOD,			// 采集值可用
		BAD,			// 采集值不可用
		TIMEOUT,		// 采集超时
		UNCONNECT,		// 采集网络中断
	};
/*		
	// 定义时间类型
	class DateTime {
		string toStr();		// “2018-01-22 01:56:32.999” 年-月-日 时:分:秒.毫秒

		long dateTime;			
	};
*/		
	// 定义用户信息类型
	struct UserInfo {
		string 		userName;		// 用户名称
		UserType 	userType;		// 用户类型
	};
		
	// 定义设备信息类型
	struct DeviceInfo {
		string devName;			// 设备名称
		DeviceType devType;		// 设备类型
	};
		
	// 定义点信息类型
	struct PointInfo {
		string pointName;	// 点名称
		int pointId;		// 点ID，查询点实时值时使用此ID。IDataMonitor::queryRealData
	};

	// 定义网口信息类型
	struct EthInfo{
		string ethName;		// 网口名称
		string ipAddr;		// 网口IP地址
		string subnetMask;	// 网口子网掩码
		string gateway;		// 网口网关
	};
		
	// 定义存储设备信息类型
	struct StorageDeviceInfo {
		string sdiName;		// 存储设备名
		long totalSpace;	// 磁盘空间大小 KB
		long freeSpace;		// 剩余磁盘空间 KB
	}

	// 定义可变数据类型变量, 这是类型的抽象基类，具体类型为VariantBool、VariantInt8、
	// VariantInt16、VariantInt32、VariantInt64、VariantReal32、VariantReal64、VariantString
	class Variant {
		VarType vt;		// 标记实际的类型
	};

	class VariantBool extends Variant {
		bool value;
	};

	class VariantInt8 extends Variant {
		byte value;
	};

	class VariantInt16 extends Variant {
		short value;
	};

	class VariantInt32 extends Variant {
		int value;
	};

	class VariantInt64 extends Variant {
		long value;
	};

	class VariantReal32 extends Variant {
		float value;
	};

	class VariantReal64 extends Variant {
		double value;
	};

	// string variant
	class VariantString extends Variant {
		string value;
	};
		
	// 定义VQT复合数据类型
	struct Vqt {
		Variant v;		// 采集的数值
		Quality q;		// 采集的质量状态
		long 	t;		// 采集的时间 与C语言中time_t类型相似，精度为毫秒
	};
		
	sequence<Result> 		ResultList;
	sequence<UserInfo> 		UserInfoList;
	sequence<string> 		StringList;
	sequence<EthInfo> 		EthInfoList;
	sequence<DeviceInfo> 	DeviceInfoList;
	sequence<PointInfo>	 	PointInfoList;
	sequence<int> 			PointIdList;
	sequence<Vqt> 			VqtList;
	sequence<StorageDeviceInfo> 	StorageDeviceInfoList;
	sequence<DeviceState>	DeviceStateList;	
};
