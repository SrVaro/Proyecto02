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

  public login(name: String, pass: String) {
    return this.http.get<Profile>(this.lucatinderUrl + 'login/' + name + '/' + pass);
  }

  public save(profile: Profile) {
    return this.http.post<Profile>(this.lucatinderUrl, profile);
  }

  public getSelection(): Observable<Profile[]>{

    return this.http.get<Profile[]>(this.lucatinderUrl + 'home');
  }

  public like(id: number){
    return this.http.get<Profile>(this.lucatinderUrl + 'like/' + id);
  }

  public dislike(id: number){
    return this.http.get<Profile>(this.lucatinderUrl + 'dislike/' + id);
  }

  public getContacts(): Observable<Profile[]>{
    return this.http.get<Profile[]>(this.lucatinderUrl + 'contacts');
  }

  public getDiscards():Observable<Profile[]>{
    return this.http.get<Profile[]> (this.lucatinderUrl + 'discards')
  }

  public getMatches():Observable<Profile[]>{
    return this.http.get<Profile[]> (this.lucatinderUrl + 'matches')
  }
  
  public edit(profile: Profile){
    return this.http.put(this.lucatinderUrl + 'edit', profile);
  }

  public getMyProfile() {
    return this.http.get<Profile>(this.lucatinderUrl + 'myprofile');
  }
  
  public delete() {
    return this.http.delete<Profile>(this.lucatinderUrl + 'delete');
  }
}
