package com.example.damsem6;

import java.util.List;

public interface IResponse {
    public void onSucces(List<Orase> lst);
    public void onError(String msj);

}
