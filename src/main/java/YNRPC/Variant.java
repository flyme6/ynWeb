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
// Generated from file `RpcCommon.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package YNRPC;

public class Variant extends Ice.ObjectImpl
{
    public Variant()
    {
        vt = VarType.VTEMPTY;
    }

    public Variant(VarType vt)
    {
        this.vt = vt;
    }

    private static class __F implements Ice.ObjectFactory
    {
        public Ice.Object create(String type)
        {
            assert(type.equals(ice_staticId()));
            return new Variant();
        }

        public void destroy()
        {
        }
    }
    private static Ice.ObjectFactory _factory = new __F();

    public static Ice.ObjectFactory
    ice_factory()
    {
        return _factory;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::YNRPC::Variant"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[1];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String ice_staticId()
    {
        return __ids[1];
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        VarType.__write(__os, vt);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        vt = VarType.__read(__is);
        __is.endReadSlice();
    }

    public VarType vt;

    public Variant
    clone()
    {
        return (Variant)super.clone();
    }

    public static final long serialVersionUID = -337466219L;
}
