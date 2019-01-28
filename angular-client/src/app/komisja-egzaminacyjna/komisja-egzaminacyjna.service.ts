import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class KomisjaEgzaminacyjnaService {
  url = 'http://localhost:8080/';
  constructor(private http: HttpClient ) { }

  getAllPracownik():Observable<Pracownik[]>{
    return this.http.get<Pracownik[]>(this.url+"pracowniki");
  }
  createKomisja(komisja: KomisjaEgzaminacyjna): Observable<KomisjaEgzaminacyjna>{
    return this.http.post<KomisjaEgzaminacyjna>(this.url+"komisji",komisja);
  }

  getAllKomisja():Observable<KomisjaEgzaminacyjna[]>{
    return this.http.get<KomisjaEgzaminacyjna[]>(this.url+"komisji");
  }

  
}
