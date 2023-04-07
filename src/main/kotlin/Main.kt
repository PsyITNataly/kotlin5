data class Likes(
    var count: Int
)

data class Post(
    val id: Int,
    val likes: Likes
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
    val post = Post(0, likes)
    WallService.add(post)
    WallService.add(Post(0, Likes(10)))
    WallService.printPosts()
    likes.count += 10
    WallService.printPosts()

}