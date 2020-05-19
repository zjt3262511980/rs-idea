package com.service;


import com.domain.Vx;

public interface VxService {
   int insertvs(int userrsid,String vxid);
   Vx selectvx(String vxsid);
}
