package com.danilo.broker;

import java.util.List;

import com.danilo.domen.Drzava;
import com.danilo.domen.Hotel;
import com.danilo.domen.OpstiDomen;
import com.danilo.domen.PretragaHotela;
import com.danilo.domen.Soba;
import com.danilo.domen.User;

public interface IBroker {
public void sacuvaj(OpstiDomen opstiDomen);
public User vratiUser(User user);
public List<OpstiDomen> vratiPoslednjiPodatakBaza(OpstiDomen opstiDomen);
public List<OpstiDomen>vratiFullTabeluBaza(OpstiDomen opstiDomen);
public List<Hotel>pretraga(Hotel hotel);
public List<Soba> sobaIzabranogHotela(Soba soba);
}
