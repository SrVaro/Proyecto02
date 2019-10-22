import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Profile } from './profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private lucatinderUrl: string;

  constructor(private http: HttpClient) { 
    this.lucatinderUrl = 'http://localhost:8080/rest/profile/';
  }

  public login(name: String) {
    this.lucatinderUrl = 'http://localhost:8080/rest/profile/';
    this.lucatinderUrl += 'login/' + name;
    return this.http.get<Profile>(this.lucatinderUrl);
  }

  public save(profile: Profile) {
    return this.http.post<Profile>(this.lucatinderUrl, profile);
  }
}
