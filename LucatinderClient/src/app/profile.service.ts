import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Profile } from './profile';
import { from, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private lucatinderUrl: string;

  constructor(private http: HttpClient) { 
    this.lucatinderUrl = 'http://localhost:8080/rest/profile/';
  }

  public login(name: String) {
    return this.http.get<Profile>(this.lucatinderUrl + 'login/' + name);
  }

  public save(profile: Profile) {
    return this.http.post<Profile>(this.lucatinderUrl, profile);
  }

  public findAll(): Observable<Profile[]>{

    return this.http.get<Profile[]>(this.lucatinderUrl + 'home');
  }

  public like(id: number){
    return this.http.get<Profile>(this.lucatinderUrl + 'like/' + id);
  }
}
