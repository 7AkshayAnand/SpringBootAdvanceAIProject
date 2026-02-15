package com.fitness.activityservice.service;

import com.fitness.activityservice.Repository.ActivityRepository;
import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
//import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ActivityService {
    private final ActivityRepository activityRepository;
    public  ActivityResponse trackActivity(ActivityRequest activityRequest) {

        Activity activity=Activity.builder().userId(activityRequest.getUserId()).
                type(activityRequest.getType()).
                duration(activityRequest.getDuration()).
                caloriesBurned(activityRequest.getCaloriesBurned()).
                startTime(activityRequest.getStartTime()).
                additionalMetrices(activityRequest.getAdditionalMetrices()).build();

        Activity savedActivity=activityRepository.save(activity);
        return mapToResponse(savedActivity);
    }

    private  ActivityResponse mapToResponse(Activity savedActivity) {

        ActivityResponse response=new ActivityResponse();

        response.setId(savedActivity.getId());
        response.setUserId(savedActivity.getUserId());
        response.setType(savedActivity.getType());
        response.setDuration(savedActivity.getDuration());
        response.setCaloriesBurned(savedActivity.getCaloriesBurned());
        response.setStartTime(savedActivity.getStartTime());
        response.setAdditionalMetrices(savedActivity.getAdditionalMetrices());
        response.setCreatedAt(savedActivity.getCreatedAt());
        response.setUpdatedAt(savedActivity.getUpdatedAt());
        return response;

    }
}
