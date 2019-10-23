import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfileService } from '../profile.service';
import { Category } from '../category';

@Component({
  selector: 'app-profile-form',
  templateUrl: './profile-form.component.html',
  styleUrls: ['./profile-form.component.css']
})
export class ProfileFormComponent {

  profile: Profile;
  category: Category[];
  hasFailed: boolean;
 
  constructor(private route: ActivatedRoute, private router: Router, private profileService: ProfileService) {
    this.profile = new Profile();
    this.hasFailed = false;
  }
 
  onSubmit() {
    this.profileService.save(this.profile).subscribe(
      result => this.gotoHome(),
      error => { this.hasFailed = true }
    )}
 
  gotoHome() {
    this.router.navigate(['/home']);
  }
}
