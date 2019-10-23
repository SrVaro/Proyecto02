import { Component, OnInit } from '@angular/core';
import { Profile } from 'selenium-webdriver/firefox';
import { Router } from '@angular/router';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit{

  profile: Profile;

  constructor(private router: Router, private profileService: ProfileService) { }

  ngOnInit(): void {
    this.profileService.getMyProfile().subscribe(result => this.profile = result);
  }

  onSubmit(){
    this.profileService.edit().subscribe(result => this.gotoForm);
  }

  gotoForm(){
    this.router.navigate(['/register'])
  }

}
