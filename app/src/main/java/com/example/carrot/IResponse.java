package com.example.carrot;

import java.util.List;

public interface IResponse {
    public void onSucces(List<Weather> lst);
    public void onError(String msj);
}
