import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PowolanieService {
  url = 'http://localhost:8080/';
  constructor(private http: HttpClient ) { }

  getAllPracownik():Observable<Pracownik[]>{
    return this.http.get<Pracownik[]>(this.url+"pracowniki");
  }
}
