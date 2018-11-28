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
 * Description: 使用点ID查询点的实时值
 * Input: ptIds 点ID列表
 * Output: values 点实时值列表
 * Return:
 * Others: 
 **/

public interface _Callback_IDataMonitor_queryRealDatas extends Ice.TwowayCallback
{
    public void response(Result __ret, Rvqt[] values);
}
