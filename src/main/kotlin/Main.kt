interface Attachment {
    val type: String
}
abstract class VideoAttachment(
    override val type: String,
    open val video: Video
) : Attachment
class Video(
    val id: Int = 1,
    val ownerId: Int = 1,
    val title: String? = "A Funny Video",
    val duration: Int = 30,
    val description: String,
    override val video: Video,
    type: String
) : VideoAttachment(type, video)

abstract class PhotoAttachment(
    override val type: String,
    open val photo: Photo
) : Attachment
class Photo(
    val id: Int = 1,
    val album_id: Int,
    val owner_id: Int = 1,
    val user_id: Int,
    val text: String?,
    val data: Int,
    val photo_130: String = "https://vk.com/some_photo_link",
    val photo_604: String = "https://vk.com/another_photo_link",
    type: String,
    override val photo: Photo
) : PhotoAttachment(type, photo)

class Audio(
    val id: Int,
    val ownerId: Int,
    val title: String?,
    val duration: Int,
    val artist: String,
)
class Document(
    val id: Int,
    val ownerId: Int,
    val title: String?,
    val size: Int,
    val ext: String
)

class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String?,
    val previes_page: String,
    val previes_url: String
)

class Note(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val text: String?,
    val data: Int,
    val comments: Int,
    val read_comments: Int
)

class Page(
    val id: Int,
    val group_id: Int,
    val creater_id: Int,
    val title: String?,
    val who_can_view: Boolean,
    val current_user_can_edit: Int,
    val current_user_can_edit_access: Int
)

class Poll(
    val id: Int,
    val ownerId: Int,
    val created: Int,
    val question: String?,
    val votes: Int
)

class PostSource(
    val type: String,
    val platform: String?,
    val data: String,
    val url: String
)

class Sticker(
    val product_id: Int,
    val sticker_id: Int?,
    val images_url: String,
    val images_width: Int,
    val images_height: Int
)

data class Likes(
    var count: Int
)

data class Post(
    val attachments: Array<Attachment> = emptyArray(),
    val id: Int,
    val likes: Likes,
    val owenId: Int,
    val fromId: Int,
    val data: Int,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val copywriter: String,
    val portType: String
)

object WallService {
    private var posts = emptyArray<Post>()

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }

    private var lastId = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId, likes = post.likes.copy())
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy(likes = post.likes)
                return true
            }
        }
        return false
    }

    fun printPosts() {
        for (post in posts) {
            println(post)
        }
    }
}

fun main() {
    val likes = Likes(0)
    val post = Post(
        id = 0,
        likes = Likes(0),
        owenId = 0,
        fromId = 0,
        data = 0,
        replyOwnerId = 0,
        replyPostId = 0,
        copywriter = "No",
        portType = "No"
    )
    WallService.add(post)
    WallService.add(Post(
        id = 0,
        likes = Likes(10),
        owenId = 0,
        fromId = 0,
        data = 0,
        replyOwnerId = 0,
        replyPostId = 0,
        copywriter = "No",
        portType = "No"
    ))
    WallService.printPosts()
    likes.count += 10
    WallService.printPosts()

}