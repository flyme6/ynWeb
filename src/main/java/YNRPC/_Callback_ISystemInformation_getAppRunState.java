// **********************************************************************
//
// Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.4
//
// <auto-generated>
//
// Generated from file `RpcService.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package YNRPC;

/**
 * Description: 获得嵌入式应用使用情况
 * Input: 
 * Output: values 返回状态列表
 * 为键值对数组，键为资源名称、值为资源使用值
 * Return:
 * Others: 
 **/

public interface _Callback_ISystemInformation_getAppRunState extends Ice.TwowayCallback
{
    public void response(Result __ret, KeyValue[] values);
}
