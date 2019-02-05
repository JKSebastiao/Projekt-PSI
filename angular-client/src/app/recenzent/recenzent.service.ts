import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecenzentService {
  
  url = 'http://localhost:8080/';
  constructor(private http: HttpClient) { }

  getAllPraca(): Observable<PracaDyplomowa[]>{
    return this.http.get<PracaDyplomowa[]>(this.url+"pracy/dopropozycja/recenzent");
  }

  addPropozycja(praca: PracaDyplomowa ): Observable<PracaDyplomowa>{
    return this.http.post<PracaDyplomowa>(this.url+"pracy/propozycja/recenzent",praca);
  }

  addRecenzent(recenzent: Recenzent ): Observable<Recenzent>{
    return this.http.put<Recenzent>(this.url+"recenzenci/"+recenzent.id,recenzent);
  }
  getRecenzentByID(id:number): Observable<Recenzent>{
    return this.http.get<Recenzent>(this.url+"recenzenci/"+id);
  }

  getAllPracownik():Observable<Pracownik[]>{
    return this.http.get<Pracownik[]>(this.url+"pracowniki");
  }

  getAllPracyZRecenzentemZaproponowany(): Observable<PracaDyplomowa[]>{
    return this.http.get<PracaDyplomowa[]>(this.url+"pracy/propozycja/recenzent");
  }
  getAllRecenzenci(): Observable<Pracownik[]>{
    return this.http.get<Pracownik[]>(this.url+"recenzenci");
  }
}
