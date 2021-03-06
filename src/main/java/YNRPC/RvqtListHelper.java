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

public final class RvqtListHelper
{
    public static void
    write(IceInternal.BasicStream __os, Rvqt[] __v)
    {
        if(__v == null)
        {
            __os.writeSize(0);
        }
        else
        {
            __os.writeSize(__v.length);
            for(int __i0 = 0; __i0 < __v.length; __i0++)
            {
                Rvqt.__write(__os, __v[__i0]);
            }
        }
    }

    public static Rvqt[]
    read(IceInternal.BasicStream __is)
    {
        Rvqt[] __v;
        final int __len0 = __is.readAndCheckSeqSize(4);
        __v = new Rvqt[__len0];
        for(int __i0 = 0; __i0 < __len0; __i0++)
        {
            __v[__i0] = Rvqt.__read(__is, __v[__i0]);
        }
        return __v;
    }
}
