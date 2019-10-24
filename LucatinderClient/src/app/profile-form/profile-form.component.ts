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
export class ProfileFormComponent implements OnInit{

  profile: Profile;
  category: Category[];
  hasFailed: boolean;
 
  constructor(private route: ActivatedRoute, private router: Router, private profileService: ProfileService) {
    this.profile = new Profile();
    this.hasFailed = false;
  }

  ngOnInit() {
    console.log(this.route.snapshot.paramMap.get("id"));
    if(this.route.snapshot.paramMap.get("id") != null){
      this.profileService.getMyProfile().subscribe(data => this.profile = data);
    }
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
