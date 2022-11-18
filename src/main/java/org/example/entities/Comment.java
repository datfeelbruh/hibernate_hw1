package org.example.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "app_comment")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @NonNull
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NonNull
    private User user;

    @CreationTimestamp
    private Timestamp created_at;
}
