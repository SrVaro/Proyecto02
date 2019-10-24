import { Component, OnInit, Input } from '@angular/core';
import { Profile } from '../profile';
import { ProfileService } from '../profile.service';


export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
}

@Component({
  selector: 'app-profile-list',
  templateUrl: './profile-list.component.html',
  styleUrls: ['./profile-list.component.css']
})

export class ProfileListComponent implements OnInit {
 
  @Input() profiles : Profile[];   
  
  @Input() home : boolean;   
  
  constructor(private profileService: ProfileService) { }

  ngOnInit() {
  }

  tiles: Tile[] = [
    {text: 'One', cols: 3, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

  like(profile: Profile){
    this.profiles = this.profiles.filter(p => p !== profile);
    this.profileService.like(profile.id_profile).subscribe(data => {
      console.log(data);
    });
  }

  dislike(profile: Profile){
    this.profiles = this.profiles.filter(p => p !== profile);
    this.profileService.dislike(profile.id_profile).subscribe(data => {
      console.log(data);
    });
  }

}
