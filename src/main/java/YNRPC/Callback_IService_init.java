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
 * Description: 初始化系统
 * Input:
 * Output: 
 * Return:
 * Others: 需要在第一个用户建立会话时调用
 **/

public abstract class Callback_IService_init
    extends IceInternal.TwowayCallback implements Ice.TwowayCallbackArg1<Result>
{
    public final void __completed(Ice.AsyncResult __result)
    {
        IServicePrxHelper.__init_completed(this, __result);
    }
}
