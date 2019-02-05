import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PracaDyplomowaService {
  url = 'http://localhost:8080/';
  constructor(private http: HttpClient) { }

  getAllPraca(): Observable<PracaDyplomowa[]>{
    return this.http.get<PracaDyplomowa[]>(this.url+"pracy");
  }

  addPraca(praca: PracaDyplomowa): Observable<PracaDyplomowa>{
    return this.http.post<PracaDyplomowa>(this.url+"pracy",praca);
  }

  updatePraca(id:number, praca: PracaDyplomowa): Observable<PracaDyplomowa>{
    return this.http.put<PracaDyplomowa>(this.url+"pracy/"+id,praca);
  }

  getPracaById(id: number):Observable<PracaDyplomowa>{
    return this.http.get<PracaDyplomowa>(this.url+"pracy/"+id);
  }
}
