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

public class VariantInt32 extends Variant
{
    public VariantInt32()
    {
        super();
    }

    public VariantInt32(VarType vt, int value)
    {
        super(vt);
        this.value = value;
    }

    private static class __F implements Ice.ObjectFactory
    {
        public Ice.Object create(String type)
        {
            assert(type.equals(ice_staticId()));
            return new VariantInt32();
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
        "::YNRPC::Variant",
        "::YNRPC::VariantInt32"
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
        return __ids[2];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[2];
    }

    public static String ice_staticId()
    {
        return __ids[2];
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, false);
        __os.writeInt(value);
        __os.endWriteSlice();
        super.__writeImpl(__os);
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        value = __is.readInt();
        __is.endReadSlice();
        super.__readImpl(__is);
    }

    public int value;

    public VariantInt32
    clone()
    {
        return (VariantInt32)super.clone();
    }

    public static final long serialVersionUID = -1541729489L;
}
